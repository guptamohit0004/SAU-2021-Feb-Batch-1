import { Helmet } from "react-helmet";
import React, { Component } from "react";

class Index extends Component {
  constructor(props) {
    super();
    this.state = {
      books: [],
      search: "",
    };
  }
  componentDidMount() {
    fetch(
      "https://raw.githubusercontent.com/bvaughn/infinite-list-reflow-examples/master/books.json"
    )
      .then((response) => response.json())
      .then((book) => {
        book = book.filter((booksingle) => {
          return (
            booksingle.isbn &&
            booksingle.shortDescription &&
            booksingle.longDescription &&
            booksingle.thumbnailUrl &&
            booksingle.status === "PUBLISH"
          );
        });
        this.setState({ books: book });
      });
  }
  render() {
    const { books, search } = this.state;
    const handleChange = (e) => {
      this.setState({ search: e.target.value });
    };
    let filteredbooks = books.filter(
      (book) =>
        book.title.toLowerCase().includes(search.toLowerCase()) ||
        book.isbn.toLowerCase().includes(search.toLowerCase()) ||
        book.shortDescription.toLowerCase().includes(search.toLowerCase()) ||
        book.longDescription.toLowerCase().includes(search.toLowerCase())
    );
    return (
      <div className="App">
        <Helmet>
          <title>All Books | AU Session Assignment</title>
        </Helmet>
        <div> Search for a Book</div>
        <input type="search" onChange={handleChange} />
        <br />
        <br />
        <br />
        <div className="card-list">
          {filteredbooks.map((book) => (
            <div key={book.isbn} className="card-container">
              <a href={`/book/${book.isbn}`}>
                <img alt={book.title} src={book.thumbnailUrl} />
                <br />
                {book.title}
              </a>
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default Index;
