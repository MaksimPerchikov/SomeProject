import { createTheme } from "@mui/material";

export enum COLOR {
  RED = "RED",
  GREEN = "GREEN",
  DEFAULT = "DEFAULT",
}

declare module "@mui/material/styles" {
  export interface Palette {
    widget: {
      background: string;
      border: string;
    };
    border: {
      main: string;
      light: string;
    };
    button: {
      background: string;
      color: string;
    };
    input: {
      background: string;
    };
  }

  export interface PaletteOptions {
    widget?: {
      background?: string;
      border?: string;
    };
    border?: {
      main?: string;
      light?: string;
    };
    button?: {
      background?: string;
      color?: string;
    };
    input?: {
      background?: string;
    };
  }

  export interface Mixins {
    button: {
      boxShadow: string;
    };
    rateColor: (color?: COLOR) => string;
  }

  export interface MixinsOptions {
    button?: {
      boxShadow?: string;
    };
    rateColor?: (color?: COLOR) => string;
  }
}

const theme = createTheme({
  palette: {
    primary: {
      main: "#fff",
    },
    success: {
      main: "#219653",
    },
    error: {
      main: "#EB5757",
    },
    warning: {
      main: "#F2994A",
    },
    widget: {
      background: "#fff",
      border: "#DBDBDB",
    },
    border: {
      main: "#F5F5F5",
      light: "#fff",
    },
    button: {
      background: "#101010",
      color: "#FFF",
    },
    input: {
      background: "#FAFAFA",
    },
    text: {
      primary: "#212121",
      secondary: "#616161",
    },
  },
  typography: {
    fontFamily: "'Exo 2', sans-serif",
  },
  mixins: {
    button: {
      boxShadow: "4px 8px 24px rgba(16, 16, 16, 0.25)",
    },
    rateColor: (color?: COLOR) => {
      switch (color) {
        case COLOR.GREEN:
          return theme.palette.success.main;
        case COLOR.RED:
          return theme.palette.error.main;
        default:
          return "inherit";
      }
    },
  },
});

export default theme;
