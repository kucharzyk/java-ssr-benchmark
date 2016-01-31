import React from "react";
import ReactDOM from "react-dom";
import ReactDOMServer from "react-dom/server";

class Fox extends React.Component {
    render() {
        return <span className="fox">{ this.props.name }</span>;
    }
}

class Box extends React.Component {
    render() {
        return <div className={'box box-'+this.props.type}>
            { this.props.children }
        </div>
    }
}

window.renderOnServer = function (name) {
    return ReactDOMServer.renderToString(
        <Box type="open">
            <Fox name={name}/>
        </Box>);
};

window.renderOnClient = function (name) {
    var container = document.getElementById('application');
    container.innerHTML = '';
    ReactDOM.render(
        <Box type="open">
            <Fox name={name}/>
        </Box>, container);
};
