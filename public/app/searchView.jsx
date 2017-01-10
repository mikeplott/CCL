import React from 'react';
import ReactDOM from 'react-dom';

class SearchComponent extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            data: []
        };
    }

    componentDidMount() {
        $.ajax({
            url: '/search-products',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
              userName:uName,
              password:pass,
              email:uEmail
              }),
            success: function(data){
              window.location.href="/index.html";
            },
        })
    }

    render() {
        return (
            <div>

            </div>
        )
    }

}
