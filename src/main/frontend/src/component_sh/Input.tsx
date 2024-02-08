import React, { useState } from "react";

interface InputProps {
  propsname: string;
  getResult: (obj: { [key: string]: string }) => void;
}

const Input: React.FC<InputProps> = ({ propsname, getResult }) => {
  const [inputValue, setInputValue] = useState("");

  return (
    <input
      name={propsname}
      value={inputValue}
      onChange={(e) => {
        setInputValue(e.target.value);
      }}
      onBlur={() => {
        getResult({ [propsname]: inputValue });
      }}
    />
  );
};

export default Input;
