import { theme } from "../../styles/theme";

export default function GoBackButton({ children, style = {}, ...props }) {
  return (
    <button
      {...props}
      style={{
        display: "inline-flex",
        alignItems: "center",
        justifyContent: "center",
        gap: "8px",
        minWidth: "clamp(180px, 16vw, 210px)",
        height: "clamp(56px, 5vw, 66px)",
        padding: "0 clamp(22px, 2vw, 28px)",
        borderRadius: theme.radius.pill,
        border: `2px solid ${theme.colors.lightBrown}`,
        background: theme.colors.tan,
        color: theme.colors.text,
        fontFamily: theme.fonts.sans,
        fontSize: theme.fontSizes.onboardingTagline,
        letterSpacing: "-0.02em",
        cursor: "pointer",
        whiteSpace: "nowrap",
        ...style,
      }}
    >
      {children}
    </button>
  );
}