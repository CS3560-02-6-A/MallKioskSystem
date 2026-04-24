import { theme } from "../../styles/theme";

export default function AppButton({
  children,
  rightIcon,
  disabled = false,
  style = {},
  ...props
}) {
  return (
    <button
      disabled={disabled}
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
        border: theme.colors.primaryStroke,
        background: disabled ? "#898989" : theme.colors.primaryGradient,
        boxShadow: theme.shadows.primaryButton,
        color: disabled ? "#F6F6F6" : theme.colors.white,
        fontFamily: theme.fonts.sans,
        fontSize: theme.fontSizes.cta,
        fontWeight: theme.fontWeights.bold,
        letterSpacing: "-0.02em",
        cursor: disabled ? "not-allowed" : "pointer",
        whiteSpace: "nowrap",
        opacity: disabled ? 0.85 : 1,
        ...style,
      }}
    >
      <span>{children}</span>
      {rightIcon}
    </button>
  );
}