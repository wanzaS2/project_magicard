import React from "react";

interface InputProps {
  name: string;
}

const Input: React.FC<InputProps> = ({ name }) => {
  return <input name={name} />;
};

export default Input;
