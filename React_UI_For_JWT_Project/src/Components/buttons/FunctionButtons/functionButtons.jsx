import React from "react";
import Buttons from "../buttons";
import './functionButtons.css'

class FunctionButtons extends Buttons {
  render() {
    return (
        <Buttons data={this.props.data} className="function_buttons" sign={this.props.sign} onClick={this.props.onClick}/>
    );
  }
}

export default FunctionButtons;