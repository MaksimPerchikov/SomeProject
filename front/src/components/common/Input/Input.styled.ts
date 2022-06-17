import { Input, InputProps, styled } from "@mui/material";

import { COLOR } from "../../../theme/main";

export interface InputStyledProps extends InputProps {
  rateColor?: COLOR;
}

export const InputStyled = styled(Input)<InputStyledProps>(
  ({ theme, rateColor }) => ({
    background: theme.palette.input.background,
    color: theme.palette.text.primary,
    border: `1px solid ${theme.mixins.rateColor(rateColor)}`,
    padding: theme.spacing(1, 2),
  }),
);
