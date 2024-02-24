import React from "react";
import Buttons from "../buttons";
import './operationButtons.css'

class OperationButtons extends Buttons{
  render() {
    return (
        <Buttons data={this.props.data} className="operation_buttons" sign={this.props.sign} onClick={this.props.onClick}/>
    );
  }
}

export default OperationButtons;
