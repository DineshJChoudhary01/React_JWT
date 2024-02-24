import React from "react";
import Buttons from "../buttons";
import './numberButtons.css'


class NumberButtons extends Buttons {
  render() {
    return (
      <Buttons data={this.props.data}  className="number_buttons" sign={this.props.sign} onClick={this.props.onClick} />
    );
  }
}

export default NumberButtons;