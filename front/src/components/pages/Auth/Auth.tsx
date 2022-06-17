import { FormControl } from "@mui/material";
import { FC } from "react";

import {
  AuthContainer,
  AuthForm,
  AuthInput,
  AuthInputLabel,
  AuthSubmit,
} from "./Auth.styled";

export const Auth: FC = () => {
  return (
    <AuthContainer>
      <AuthForm>
        <FormControl>
          <AuthInputLabel htmlFor="email">Email</AuthInputLabel>
          <AuthInput id="email" type="text" disableUnderline />
        </FormControl>
        <FormControl>
          <AuthInputLabel htmlFor="password">Пароль</AuthInputLabel>
          <AuthInput id="password" type="password" disableUnderline />
        </FormControl>
        <AuthSubmit type="submit">Войти</AuthSubmit>
      </AuthForm>
    </AuthContainer>
  );
};
