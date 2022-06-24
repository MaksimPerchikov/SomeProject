import { ChangeEvent, useCallback, useState } from "react";

export const useInputState = <T extends object>() => {
  const [inputState, setInputState] = useState({} as T);

  const handleInputChange = useCallback(
    (e: ChangeEvent<HTMLInputElement>) => {
      const { id, value } = e.target;

      setInputState({ ...inputState, [id]: value });
    },
    [inputState],
  );

  return {
    inputState: inputState,
    handleInputChange,
  };
};
