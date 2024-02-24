import React from "react";

class CalculatorModel extends React.Component{

  constructor(props){
    super(props);
    this.numberButtons = [
      { type: "NUMBER", sign: "0" ,value:"0"},
      { type: "NUMBER", sign: "1",value:"1" },
      { type: "NUMBER", sign: "2",value:"2" },
      { type: "NUMBER", sign: "3",value:"3"},
      { type: "NUMBER", sign: "4",value:"4" },
      { type: "NUMBER", sign: "5",value:"5" },
      { type: "NUMBER", sign: "6",value:"6" },
      { type: "NUMBER", sign: "7",value:"7" },
      { type: "NUMBER", sign: "8",value:"8" },
      { type: "NUMBER", sign: "9",value:"9" },
    ];
    this.operationButtons = [
      { type: "OPERATION", sign: "+",value:"ADDITION"},
      { type: "OPERATION", sign: "-",value:"SUBTRACTION" },
      { type: "OPERATION", sign: "*",value:"MULTIPLICATION" },
      { type: "OPERATION", sign: "/",value:"DIVISION" },
      { type: "OPERATION", sign: "=",value:"EQUAL" },
    ];
  
    this.functionButtons = [
      { type: "FUNCTION", sign: "AC",value:"AC" },
      { type: "FUNCTION", sign: "C",value:"C" },
      { type: "FUNCTION", sign: "UD",value:"UD" },
      { type: "FUNCTION", sign: "RD",value:"RD" },
    ];
    
    
  }
 

}

export default CalculatorModel;
