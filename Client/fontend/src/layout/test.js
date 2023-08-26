import { useState } from "react";
import React from "react";

function Test() {

    const [couter, setCouter] = useState(1);
    const click = () => {
        setCouter(couter + 1);
    }
    return (
        <div className="Test">
            <h1>{couter}</h1>
            <button onClick={click}>click</button>
        </div>
    );

}
export default Test;