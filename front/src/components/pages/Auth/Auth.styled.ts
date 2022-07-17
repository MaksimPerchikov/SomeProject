import { InputLabel, styled } from "@mui/material";

import { ButtonStyled } from "../../common/Button/Button.styled";
import { InputStyled } from "../../common/Input/Input.styled";

export const AuthContainer = styled("div")(() => ({
  width: "100%",
  height: "100vh",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
}));

export const AuthForm = styled("form")(({ theme }) => ({
  flex: `0 1 ${theme.spacing(60)}`,
  height: theme.spacing(40),
  display: "flex",
  flexDirection: "column",
  gap: theme.spacing(3),
  background: theme.palette.primary.main,
}));

export const AuthInput = styled(InputStyled)(({ theme }) => ({
  width: theme.spacing(37),
  height: theme.spacing(8),
  borderRadius: theme.spacing(1.5),
  fontSize: theme.spacing(2),
}));

export const AuthInputLabel = styled(InputLabel)(({ theme }) => ({
  color: theme.palette.text.primary,
  fontSize: theme.spacing(2),
}));

export const AuthSubmit = styled(ButtonStyled)(({ theme }) => ({
  width: theme.spacing(37),
  height: theme.spacing(8),
  borderRadius: theme.spacing(13),
  fontSize: theme.spacing(2),
}));
