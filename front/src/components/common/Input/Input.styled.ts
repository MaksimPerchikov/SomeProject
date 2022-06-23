import { Input, InputProps, styled, Theme } from "@mui/material";

import { COLOR } from "../../../theme/main";

export interface InputStyledProps extends InputProps {
  isError?: boolean;
  isFilled?: boolean;
}

const getBorder = (theme: Theme, isError?: boolean, isFilled?: boolean) => {
  if (isError) return COLOR.RED;
  if (isFilled) return COLOR.INPUT_BORDER;
  return COLOR.INPUT_BORDER_LIGHT;
};

export const InputStyled = styled(Input)<InputStyledProps>(
  ({ theme, isError, isFilled }) => ({
    background: theme.palette.input.background,
    color: theme.palette.text.primary,
    padding: theme.spacing(1, 2),
    border: `1px solid ${theme.mixins.rateColor(
      getBorder(theme, isError, isFilled),
    )}`,
    transition: theme.transitions.create("all", {
      duration: theme.transitions.duration.standard,
    }),
    "&:hover": {
      borderColor: theme.palette.input.border,
    },
  }),
);
