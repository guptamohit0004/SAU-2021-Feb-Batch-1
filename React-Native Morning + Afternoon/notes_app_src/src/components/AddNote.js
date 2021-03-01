import React from "react";
import {
  View,
  Button,
  TextInput,
  StyleSheet,
  navigation,
  AsyncStorage,
} from "react-native";

export default class AddNote extends React.Component {
  state = {
    title: "",
    description: "",
  };
  onChangeText = (key, val) => {
    this.setState({ [key]: val });
  };
  addNote = async () => {
    const { title, description } = this.state;
    try {
      let data = await AsyncStorage.getItem("username1");
      data = JSON.parse(data);
      data.data.push({
        title: title,
        description: description,
        date: new Date(),
      });
      if (data)
        await AsyncStorage.setItem(
          "username1",
          JSON.stringify({ username: data.username, data: data.data })
        );
      this.props.navigation.navigate("All Notes");
    } catch (err) {}
  };

  render() {
    return (
      <View style={styles.container}>
        <TextInput
          style={styles.input}
          placeholder="Title of Note"
          autoCapitalize="none"
          placeholderTextColor="white"
          onChangeText={(val) => this.onChangeText("title", val)}
        />
        <TextInput
          style={styles.input}
          placeholder="Description of Note"
          autoCapitalize="none"
          placeholderTextColor="white"
          onChangeText={(val) => this.onChangeText("description", val)}
        />
        <Button title="Add Note" onPress={this.addNote} />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  input: {
    width: 350,
    height: 55,
    backgroundColor: "#42A5F5",
    margin: 10,
    padding: 8,
    color: "white",
    borderRadius: 14,
    fontSize: 18,
    fontWeight: "500",
  },
  container: {
    backgroundColor: "#fff",
    marginBottom: 20,
    overflow: "hidden",
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
});
