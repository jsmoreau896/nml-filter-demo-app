import React from 'react';

class RowCreator extends React.Component {

    render(){

        var country = this.props.item;

        return <tr>
                    <td>{country.cioc}</td>
                    <td>{country.name}</td>
                    <td>{country.capital}</td>
                    <td>{country.region}</td>
                    <td>{country.subregion}</td>
                </tr>
    }
}

export default RowCreator;