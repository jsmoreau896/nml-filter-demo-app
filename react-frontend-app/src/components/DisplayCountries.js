import React from 'react';
import RowCreator from './RowCreator';
import Axios from 'axios';


class DisplayCountries extends React.Component {

    constructor(props){
        super(props);
        this.state = {countries:[],
                      countriesClone:[]
        };
    }

    componentDidMount() {
        const axios = require('axios');
        const url = 'http://localhost:8080/demo/api/countries';
        axios.get(url).then(res=>{
            console.log(res.data);
            this.setState({countries:res.data,
                           countriesClone:res.data});

        }).catch(error=>{
            console.error('Error', error);
        })
      }

    handleOnChange(event){
        var filteredString = event.target.value;
        var filteredCountries = [];

        for(var country of this.state.countries){
            if(country.cioc.toLowerCase().indexOf(filteredString.toLowerCase())>=0 ||
                country.name.toLowerCase().indexOf(filteredString.toLowerCase())>=0 ||
                country.capital.toLowerCase().indexOf(filteredString.toLowerCase())>=0 ||
                country.region.toLowerCase().indexOf(filteredString.toLowerCase())>=0 ||
                country.subregion.toLowerCase().indexOf(filteredString.toLowerCase())>=0 ){
                    filteredCountries.push(country);
            }
        }

        this.setState({countriesClone:filteredCountries});
    }


    render(){

        return (<div>
                    <div class="headerBox">
                        <div class="row">
                            <div class="col-sm-12 text-center">
                                <h1>Search Countries</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 text-center">
                                <h3>Demo to filter the list of countries</h3><br/>
                            </div>
                        </div>
                    </div>

                    <div class="searchBox">
                        <div class="row text-right">
                            <div class="col-sm-3"/>
                            <div class="col-sm-6 text-center">
                             <br/><input type="text" class="form-control input-lg" placeholder="Search any field by name" onChange={this.handleOnChange.bind(this)}/><br/>
                            </div>
                            <div class="col-sm-3"/>
                        </div>
                    </div>

                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12"><br/>

                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>CIOC</th>
                                            <th>Country</th>
                                            <th>Capital</th>
                                            <th>Region</th>
                                            <th>Sub Region</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.countriesClone.map(country => <RowCreator item={country} key={country.cioc}/>)}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
        )}
}

export default DisplayCountries;