import { ButtonBase, ButtonProps, styled } from "@mui/material";

import { COLOR } from "../../../theme/main";

export const ButtonStyled = styled(ButtonBase)<ButtonProps>(({ theme }) => ({
  color: theme.palette.button.color,
  background: theme.palette.button.background,
  boxShadow: theme.mixins.button.boxShadow,
  padding: theme.spacing(1, 2),
  fontWeight: theme.typography.fontWeightBold,
  border: `1px solid ${theme.mixins.rateColor(COLOR.TRANSPARENT)}`,
  transition: theme.transitions.create("all", {
    duration: theme.transitions.duration.complex,
  }),
  "&:hover": {
    background: theme.palette.button.hover,
    color: theme.palette.text.primary,
    boxShadow: "1px 3px 11px -5px rgba(34, 60, 80, 0.2)",
    borderColor: theme.mixins.rateColor(COLOR.BUTTON_BORDER),
  },
  "&:active": {
    boxShadow: "none",
  },
}));
