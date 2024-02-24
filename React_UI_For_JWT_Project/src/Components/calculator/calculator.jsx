import React from "react";
import Display from "../display/display";
import FunctionButtons from "../buttons/FunctionButtons/functionButtons";
import NumberButtons from "../buttons/NumberButtons/numberButtons";
import OperationButtons from "../buttons/OperationButtons/operationButtons";
import CalculatorModel from "./calculatorModel";
import "./calculator.css";
import axios from "axios";

class Calculator extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      expression: "",
    };
  }

  model = new CalculatorModel();
  numberButtons = this.model.numberButtons;
  functionButtons = this.model.functionButtons;
  operationButtons = this.model.operationButtons;
  numbervalue=""
  inputArray = [];
  undo = [];
  redo = [];
  currentState=""
  resultNumber = 0;

  handleButtonClick = async (data) => {
    switch (data.type) {
      case "NUMBER":
      case "OPERATION":
        if (data.type === "NUMBER" && this.numbervalue === "") {
          this.numbervalue = data.value;
          this.setState({ expression: this.state.expression + data.sign });
        } else if(data.type === "NUMBER" && this.numbervalue !== ""){
          this.numbervalue += data.value;
          this.setState({ expression: this.state.expression + data.sign });
        }
        if (data.type === "OPERATION" && data.sign !== "=") {

          if(this.numbervalue!==""){
            this.inputArray.push({ type: "NUMBER", value: this.numbervalue });
          }
          
          this.inputArray.push({ type: data.type, value: data.value });
          this.setState({ expression: this.state.expression + data.sign });
          this.numbervalue=""
        }
        if (data.type === "OPERATION" && data.sign === "=") {
            if(this.numbervalue!==""){
              this.inputArray.push({ type: "NUMBER", value: this.numbervalue });
            }
          var output;
          try {
            console.log(this.inputArray)
            const jsonData = JSON.stringify(this.inputArray);
            console.log(jsonData)
            const response = await axios.post(
              "http://localhost:8080/BackendForcalculator/calc3",
              jsonData,
              {
                headers: {
                  "Content-Type": "application/json",
                },
              }
            );

            this.setState({ expression: response.data });
            output = response.data.toString();
            this.undo.push(output);
            this.redo.push(output);
            console.log("Response:", response.data);
          } catch (error) {
            console.error("Error sending data:", error);
          }
          this.inputArray = [];
          this.inputArray.push({ type: "NUMBER", value: output });
      this.numbervalue=""
        }
        break;

      case "FUNCTION":
        console.log(data.sign);
        if (data.sign === "C" ) {
          this.setState({expression: this.state.expression.toString().slice(0, -1),});
          this.numbervalue=this.numbervalue.substring(0,this.numbervalue.length-1); 
         var stringLength=this.inputArray[this.inputArray.length-1].value.length;
         console.log(stringLength)
          this.inputArray[this.inputArray.length-1].value=this.inputArray[this.inputArray.length-1].value.substring(0,stringLength-1); 
          console.log(this.inputArray)
        } else if (data.sign === "AC") {
          this.setState({ expression: "" });
          this.inputArray = [];
          this.numbervalue=""
        } else if (data.sign === "UD") {
          this.resultNumber += 1;
          this.currentState=this.undo[this.undo.length-1-this.resultNumber]
          this.setState({expression:this.currentState});  
          
        } else if (data.sign === "RD") {
          console.log("IN RD");
          this.resultNumber -= 1;
          this.currentState=this.undo[this.undo.length-1-this.resultNumber]
          this.setState({expression:this.currentState});
        } else {
          console.log("Nothing worked in case FUNCTION");
        }
        break;

      default:
        console.log("IN DEFAULT");
        break;
    }
  };

  render() {
    return (
      <div className="calculator">
        <Display sign={this.state.expression} />
        <div className="functionButtons">
          {this.functionButtons.map((funBtnData) => (
            <FunctionButtons
              data={funBtnData}
              sign={funBtnData.sign}
              onClick={this.handleButtonClick}
            />
          ))}
        </div>
        <div className="buttons">
          <div className="numberButtons">
            {this.numberButtons.map((nubBtnData) => (
              <NumberButtons
                sign={nubBtnData.sign}
                data={nubBtnData}
                onClick={this.handleButtonClick}
              />
            ))}
          </div>
          <div className="operationButtons">
            {this.operationButtons.map((opeBtnData) => (
              <OperationButtons
                sign={opeBtnData.sign}
                data={opeBtnData}
                onClick={this.handleButtonClick}
              />
            ))}
          </div>
        </div>
      </div>
    );
  }
}

export default Calculator;
