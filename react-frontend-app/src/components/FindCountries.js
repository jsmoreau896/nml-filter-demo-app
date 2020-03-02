import React from 'react';

class FindCountries extends React.Component {

    handleSubmit(event){
        this.props.history.push('displayCountries');
    }

    render(){
        return (<div>
            <h2>Find Countries:</h2>
            <form>
                Search:<input type="text" name="search" onChange={(event)=>{this.search=event.target.value}}/>
                <button onClick={this.handleSubmit.bind(this)}/>
            </form>
        </div>)
    }
}

export default FindCountries;