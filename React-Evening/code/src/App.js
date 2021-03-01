import React, { Fragment } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import "./App.css";

import Index from "./components/Index";
import Book from "./components/Book";

function App() {
  return (
    <div>
      <Router>
        <Fragment>
          <Switch>
            <Route exact path="/" component={Index} />
            <Route exact path="/book/:id" component={Book} />
          </Switch>
        </Fragment>
      </Router>
    </div>
  );
}

export default App;
