import React from 'react';
import './display.css'

class Display extends React.Component {
  render() {
    return (
      <div className="display">
        {this.props.sign}
      </div>
    );
  }
}

export default Display;
