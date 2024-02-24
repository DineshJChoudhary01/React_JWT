import React from "react";
import './buttons.css'

class Buttons extends React.Component {


  render() {
    return (
      <button className={this.props.className} onClick={() => this.props.onClick(this.props.data)} data={this.props.data}>{this.props.sign}</button>
    );
  }
}

export default Buttons;