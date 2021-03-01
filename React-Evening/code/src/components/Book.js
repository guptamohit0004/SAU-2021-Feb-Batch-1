import React, { Component } from "react";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import CardHeader from "@material-ui/core/CardHeader";
import Avatar from "@material-ui/core/Avatar";
import Typography from "@material-ui/core/Typography";
import { withStyles } from "@material-ui/styles";
import { red } from "@material-ui/core/colors";
import { Helmet } from "react-helmet";

class Book extends Component {
  constructor(props) {
    super(props);
    this.state = {
      books: {},
      search: "",
      loading: true,
    };
  }
  componentDidMount() {
    fetch(
      `https://raw.githubusercontent.com/bvaughn/infinite-list-reflow-examples/master/books.json`
    )
      .then((response) => response.json())
      .then((book) => {
        book = book.filter((booksingle) => {
          return booksingle.isbn === this.props.match.params.id;
        });
        this.setState({ books: book[0], loading: false });
      });
  }
  render() {
    let { books, loading } = this.state;
    const { classes } = this.props;
    return (
      <div
        className="App"
        style={{
          display: "flex",
          "justify-content": "center",
          " align-items": "center",
        }}
      >
        {books !== null && !loading && books !== undefined ? (
          <Card className={classes.root}>
            <Helmet>
              <title>{books.title}</title>
              <meta name="description" content={books.shortDescription} />
            </Helmet>
            <CardHeader
              avatar={
                <Avatar aria-label="book" className={classes.avatar}>
                  {books.title.substring(0, 1)}
                </Avatar>
              }
              title={`${books.title} by (${books.authors[0]})`}
              subheader={books.publishedDate.$date.substring(0, 10)}
            />
            <CardMedia
              className={classes.media}
              image={books.thumbnailUrl}
              title={books.title}
            />
            <CardContent>
              <Typography
                style={{ fontWeight: 600 }}
                variant="body2"
                color="textSecondary"
                component="p"
              >
                Book Description
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                {books.shortDescription}
              </Typography>
              <Typography
                style={{ fontWeight: 600 }}
                variant="body2"
                color="textSecondary"
                component="p"
              >
                Book Categories
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                {books.categories.map((book) => (
                  <div>{book}</div>
                ))}
              </Typography>
              <Typography
                style={{ fontWeight: 600 }}
                variant="body2"
                color="textSecondary"
                component="p"
              >
                Book Status
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                {books.status}
              </Typography>
            </CardContent>
          </Card>
        ) : (
          <div></div>
        )}
      </div>
    );
  }
}

const styles = (theme) => ({
  root: {
    maxWidth: 345,
  },
  media: {
    height: "100px",
    paddingTop: "66.25%", // 16:9
  },
  avatar: {
    backgroundColor: red[500],
  },
});

export default withStyles(styles)(Book);
