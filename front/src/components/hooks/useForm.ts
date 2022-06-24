import { ChangeEvent, useCallback, useState } from "react";

import { useInputState } from "./useInputState";

export type IValidateScheme<T> = {
  [K in keyof T]: boolean;
};

export const useForm = <T extends object>() => {
  const { inputState, handleInputChange } = useInputState<T>();
  const [error, setError] = useState({} as IValidateScheme<T>);

  const handleInputForm = useCallback(
    (e: ChangeEvent<HTMLInputElement>) => {
      const { id, required, value } = e.target;
      if (required) {
        setError({
          ...error,
          [id]: !value.length,
        });
      }
      handleInputChange(e);
    },
    [handleInputChange, error],
  );

  return {
    formState: inputState,
    error,
    handleInputForm,
  };
};
