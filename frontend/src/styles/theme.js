const palette = {
  primaryTop: "#BE8ACC",
  primaryBottom: "#753B96",
  primaryStroke: "#6A3B84",
  darkBrown: "#463F3A",
  lightBrown: "#957F7E",
  tan: "#C3A29E",
  offWhite: "#F4F3EE",
  eggplant: "#9D8AA2",
  palePink: "#EBE4E1",
  white: "#FFFFFF",
};

export const theme = {
  colors: {
    page: palette.offWhite,
    text: palette.darkBrown,
    mutedText: palette.darkBrown,
    link: palette.darkBrown,
    primaryGradient: `linear-gradient(180deg, ${palette.primaryTop} 0%, ${palette.primaryBottom} 100%)`,
    primaryStroke: palette.primaryStroke,
    white: palette.white,
    tan: palette.tan,
    lightBrown: palette.lightBrown,
    eggplant: palette.eggplant,
    palePink: palette.palePink,
    offWhite: palette.offWhite,
  },

  fonts: {
    display: '"Playfair Display", serif',
    sans: '"Raleway", sans-serif',
  },

  fontSizes: {
    onboardingWelcome: "clamp(24px, 2.1vw, 36px)",
    onboardingTitle: "clamp(42px, 4.1vw, 64px)",
    onboardingTagline: "clamp(18px, 1.6vw, 24px)",
    onboardingLink: "clamp(16px, 1.3vw, 20px)",
    cta: "clamp(20px, 1.6vw, 26px)",
  },

  fontWeights: {
    light: 300,
    regular: 400,
    bold: 700,
  },

  lineHeights: {
    tightest: 0.5,
    tight: 1,
    normal: 1.2,
  },

  radius: {
    pill: "999px",
  },

  shadows: {
    primaryButton:
      "inset 0 2px 0 rgba(255,255,255,0.35), 0 3px 0 rgba(106,59,132,0.32), 0 6px 14px rgba(70,63,58,0.16)",
    dropShadow: "0.5px 0.5px 4px rgba(0, 0, 0, 0.25)",
  },
};