import { theme } from "../../styles/theme";

export default function AppButton({ children, rightIcon, style = {}, ...props }) {
  return (
    <button
      {...props}
      style={{
        display: "inline-flex",
        alignItems: "center",
        justifyContent: "center",
        gap: "10px",
        minWidth: "clamp(180px, 16vw, 210px)",
        height: "clamp(56px, 5vw, 66px)",
        padding: "0 clamp(22px, 2vw, 28px)",
        borderRadius: theme.radius.pill,
        border: `2px solid ${theme.colors.primaryStroke}`,
        background: theme.colors.primaryGradient,
        boxShadow: theme.shadows.primaryButton,
        color: theme.colors.white,
        fontFamily: theme.fonts.sans,
        fontSize: theme.fontSizes.cta,
        fontWeight: theme.fontWeights.bold,
        letterSpacing: "-0.02em",
        cursor: "pointer",
        whiteSpace: "nowrap",
        ...style,
      }}
    >
      <span>{children}</span>
      {rightIcon}
    </button>
  );
}