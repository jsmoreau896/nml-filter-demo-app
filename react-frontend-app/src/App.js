import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Route,Switch} from 'react-router-dom';
import FindCountries from './components/FindCountries';
import DisplayCountries from './components/DisplayCountries';

function App() {
  return (
    <div className="App">
       <link
          rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossOrigin="anonymous"
        />
      <Switch>
        <Route exact path="/" component={DisplayCountries}/>
        <Route exact path="/findCountries" component={FindCountries}/>
      </Switch>
    </div>
  );
}

export default App;
