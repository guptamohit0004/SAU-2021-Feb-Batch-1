import React from "react";
import { View, StyleSheet, Text, TouchableOpacity, Button } from "react-native";

export default function NewsCard({ data, deleteAction }) {
  return (
    <View style={styles.card}>
      <View style={styles.textCont}>
        <Text style={styles.title}>Title-{data.title}</Text>
        <Text style={styles.subTitle}>Description-{data.description}</Text>
        <Text style={styles.date}>
          Created On-{new Date(data.date).toString().substring(0, 15)}
        </Text>
        <TouchableOpacity style={styles.button}>
          <Button
            color="red"
            onPress={() => deleteAction(data)}
            title="Delete Note"
          />
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    borderRadius: 15,
    backgroundColor: "#fff",
    marginBottom: 20,
    overflow: "hidden",
  },
  button: {
    marginLeft: "auto",
    marginRight: 0,
  },
  date: {
    color: "#c90086",
    marginVertical: 5,
    fontWeight: "bold",
  },
  img: {
    width: "100%",
    height: 200,
  },
  subTitle: {
    color: "#00b5a6",
    fontWeight: "bold",
  },
  textCont: {
    padding: 20,
  },
  title: {
    marginBottom: 8,
  },
});
