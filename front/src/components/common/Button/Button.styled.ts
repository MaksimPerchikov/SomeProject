import { ButtonBase, ButtonProps, styled } from "@mui/material";

export const ButtonStyled = styled(ButtonBase)<ButtonProps>(({ theme }) => ({
  color: theme.palette.button.color,
  background: theme.palette.button.background,
  boxShadow: theme.mixins.button.boxShadow,
  padding: theme.spacing(1, 2),
  fontWeight: theme.typography.fontWeightBold,
}));
