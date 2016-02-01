/** @jsx h */

import preact from "preact";
import preactRenderToString from "preact-render-to-string";

const render = preactRenderToString;
const { h,Component } = preact;


// Classical components work
class Fox extends Component {
    render({ name }) {
        return <span className="fox">{ name }</span>;
    }
}

// ... and so do pure functional components:
const Box = ({ type, children }) => (
    <div className={'box box-'+type}>{ children }</div>
);

window.renderOnServer = function (name) {
    return render(<Box type="open">
        <Fox name={name}/>
    </Box>);
};

window.renderOnClient = function (name) {
    var container = document.getElementById('application');
    preact.render(<Box type="open">
        <Fox name={name}/>
    </Box>, container, container.lastChild);
};
