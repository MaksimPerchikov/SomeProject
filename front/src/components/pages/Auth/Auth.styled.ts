import {
  FormControl,
  FormHelperText,
  FormLabel,
  InputLabel,
  styled,
} from "@mui/material";

import { COLOR } from "../../../theme/main";
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
  display: "flex",
  flexDirection: "column",
  alignItems: "center",
  background: theme.palette.primary.main,
}));

export const AuthInput = styled(InputStyled)(({ theme }) => ({
  width: theme.spacing(37),
  height: theme.spacing(8),
  borderRadius: theme.spacing(1.5),
  fontSize: theme.spacing(2),
  position: "relative",
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
  marginTop: theme.spacing(),
}));

export const HelperText = styled(FormHelperText)(({ theme }) => ({
  color: theme.mixins.rateColor(COLOR.RED),
  position: "absolute",
  top: "100%",
  right: 0,
}));

export const FormInfo = styled(FormLabel)<{ isError?: boolean }>(
  ({ theme, isError }) => ({
    margin: "0 auto",
    ...(isError && { color: theme.mixins.rateColor(COLOR.RED) }),
  }),
);

export const InputControl = styled(FormControl)(({ theme }) => ({
  marginBottom: theme.spacing(3),
}));
