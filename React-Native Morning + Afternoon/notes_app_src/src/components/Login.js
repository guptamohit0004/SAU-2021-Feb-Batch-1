import React, { useState, useEffect } from "react";
import {
  Text,
  TextInput,
  View,
  StyleSheet,
  Button,
  AsyncStorage,
} from "react-native";

const Login = ({ navigation }) => {
  const [username, setUserName] = useState("");
  const [Password, setPassword] = useState("");
  useEffect(() => {
    checkAuth();
  });
  const checkAuth = async () => {
    const userName = await AsyncStorage.getItem("username1");
    let data = JSON.parse(userName);
    if (data && data.username) {
      navigation.navigate("All Notes");
    }
    return;
  };
  const login = async () => {
    let data = await AsyncStorage.getItem("username1");
    data = JSON.parse(data);
    if (data)
      await AsyncStorage.setItem(
        "username1",
        JSON.stringify({ username: username, data: data.data })
      );
    else
      await AsyncStorage.setItem(
        "username1",
        JSON.stringify({ username: username, data: [] })
      );
    navigation.navigate("All Notes");
  };
  return (
    <View style={Styles.container}>
      <Text style={Styles.loginTextStyle}>Login</Text>
      <TextInput
        style={Styles.textInputStyle}
        onChangeText={(text) => setUserName(text)}
        placeholder="Please enter your username..."
      />
      <TextInput
        secureTextEntry={true}
        style={Styles.textInputStyle}
        onChangeText={(text) => setPassword(text)}
        placeholder="Please enter your Password..."
      />
      <Button title="Log me in" onPress={login} />
    </View>
  );
};

const Styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  loginTextStyle: {
    fontSize: 25,
    fontWeight: "700",
    marginVertical: 20,
  },
  textInputStyle: {
    borderColor: "black",
    borderWidth: 1,
    borderRadius: 5,
    fontSize: 20,
    padding: 5,
    width: "70%",
    marginBottom: 20,
  },
});

export default Login;
