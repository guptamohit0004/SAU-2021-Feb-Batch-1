import React, { useEffect, useState } from "react";
import {
  Text,
  SafeAreaView,
  Platform,
  View,
  StyleSheet,
  ActivityIndicator,
  Button,
  FlatList,
  Alert,
  AsyncStorage,
} from "react-native";
import NewsCard from "./NewsCard";

export default function NotesScreen(props) {
  const [articles, setArticles] = useState([]);
  const [username, setUsername] = useState([]);
  useEffect(() => {
    fetchData();
  });
  const fetchData = async () => {
    let data = await AsyncStorage.getItem("username1");
    data = JSON.parse(data);
    setUsername(data.username);
    setArticles(data.data.reverse());
  };
  const deleteAction = async (data) => {
    const mm = articles.filter((item) => item.title !== data.title);
    await AsyncStorage.setItem(
      "username1",
      JSON.stringify({ username: username, data: mm })
    );
    alert(
      "Note Deleted Successfully.Congratulations on completing the Note Task."
    );
  };
  const renderArticles = () => {
    if (articles.length > 0) {
      return (
        <FlatList
          data={articles}
          renderItem={({ item }) => (
            <NewsCard
              data={item}
              deleteAction={deleteAction}
              navigation={props.navigation}
            />
          )}
          keyExtractor={(item) => item.date}
          initialNumToRender={5}
        />
      );
    }
    return (
      <View>
        <Text>No Notes Present. Please Add new Notes.</Text>
      </View>
    );
  };
  const newNote = async () => {
    props.navigation.navigate("Add Note");
  };
  return (
    <SafeAreaView style={Styles.mainContainer}>
      <View>
        <Button title="Add Note" onPress={newNote} />
      </View>
      {renderArticles()}
    </SafeAreaView>
  );
}

const Styles = StyleSheet.create({
  mainContainer: {
    marginTop: Platform.OS === "android" ? 25 : 0,
  },
});
