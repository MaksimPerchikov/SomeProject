import React, { ChangeEvent, FC, useCallback, useState } from "react";

import {
  AuthContainer,
  AuthForm,
  AuthInput,
  AuthInputLabel,
  AuthSubmit,
  InputControl,
} from "./Auth.styled";

export interface IAuthForm {
  login?: string;
  password?: string;
}

export const Auth: FC = () => {
  const [form, setForm] = useState<IAuthForm>({});

  const handleChange = useCallback(
    (e: ChangeEvent<HTMLInputElement>) => {
      const { id, value } = e.target;

      setForm({ ...form, [id]: value });
    },
    [form],
  );

  const handleSubmit = useCallback((e: React.FormEvent) => {
    e.preventDefault();
  }, []);

  return (
    <AuthContainer>
      <AuthForm onSubmit={handleSubmit}>
        {/* <FormInfo>Неверный логин или пароль</FormInfo> */}
        <InputControl>
          <AuthInputLabel htmlFor="login">Логин</AuthInputLabel>
          <AuthInput
            id="login"
            type="text"
            disableUnderline
            onChange={handleChange}
            value={form?.login}
            isFilled={!!form?.login}
            // isError={!form?.login}
          />
          {/* {!form.login && <HelperText>Обязательное поле</HelperText>} */}
        </InputControl>
        <InputControl>
          <AuthInputLabel htmlFor="password">Пароль</AuthInputLabel>
          <AuthInput
            id="password"
            type="password"
            disableUnderline
            onChange={handleChange}
            value={form?.password}
            isFilled={!!form?.password}
            // isError={!form?.password}
          />
          {/* {!form.password && <HelperText>Обязательное поле</HelperText>} */}
        </InputControl>
        <AuthSubmit type="submit">Войти</AuthSubmit>
      </AuthForm>
    </AuthContainer>
  );
};
