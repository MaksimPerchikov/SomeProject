import React, { FC, useCallback } from "react";

import { useForm } from "../../hooks/useForm";
import {
  AuthContainer,
  AuthForm,
  AuthInput,
  AuthInputLabel,
  AuthSubmit,
  HelperText,
  InputControl,
} from "./Auth.styled";

export interface IAuthForm {
  login?: string;
  password?: string;
}

export const Auth: FC = () => {
  const { formState, handleInputForm, error } = useForm<IAuthForm>();

  const handleSubmit = useCallback((e: React.FormEvent) => {
    e.preventDefault();
  }, []);

  return (
    <AuthContainer>
      <AuthForm onSubmit={handleSubmit} noValidate>
        {/* <FormInfo>Неверный логин или пароль</FormInfo> */}
        <InputControl>
          <AuthInputLabel htmlFor="login" required>
            Логин
          </AuthInputLabel>
          <AuthInput
            id="login"
            type="text"
            disableUnderline
            onChange={handleInputForm}
            value={formState?.login}
            isFilled={!!formState?.login}
            isError={error.login}
            required
          />
          {error.login && <HelperText>Обязательное поле</HelperText>}
        </InputControl>
        <InputControl>
          <AuthInputLabel htmlFor="password" required>
            Пароль
          </AuthInputLabel>
          <AuthInput
            id="password"
            type="password"
            disableUnderline
            onChange={handleInputForm}
            value={formState?.password}
            isFilled={!!formState?.password}
            isError={error.password}
            required
          />
          {error.password && <HelperText>Обязательное поле</HelperText>}
        </InputControl>
        <AuthSubmit type="submit">Войти</AuthSubmit>
      </AuthForm>
    </AuthContainer>
  );
};
