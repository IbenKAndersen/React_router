import React from "react";
import { BrowserRouter as Router, Route, NavLink, Link, Switch } from "react-router-dom";
import data from "./data/data.json";

function App() {
  return (
    <Router>
      <div>
        <Welcome />
        <NavLink to="/all">All Users</NavLink>
        <Content />
      </div>
    </Router>
  );
}
export default App;

const Content = () => {
  return (
    <Switch>
      <Route exact path="/"> <Welcome /> </Route>
      <Route path="/all"> <Users /> </Route>
      <Route path="/details/:index"> <Details /> </Route>
    </Switch>
  )
}

function Welcome() {
  return (
    <div>
      <h2>Welcome</h2>
    </div>
  );
}

function Users() {
  const users = data.users;
  return (
    users.map((user, index) => {
      return (
        <div>
          {user.first + " " + user.last}
          <Link to={/details/+index} >Details</Link>
        </div>
      )
    })
  )
}

function Details() {
  return (
    <div>
      Details
    </div>
  );
}
