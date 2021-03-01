import React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";

import NotesScreen from "./src/components/NotesScreen";
import AddNote from "./src/components/AddNote";
import Login from "./src/components/Login";

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={Login} />
        <Stack.Screen name="All Notes" component={NotesScreen} />
        <Stack.Screen name="Add Note" component={AddNote} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;
