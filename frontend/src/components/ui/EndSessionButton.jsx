import { theme } from "../../styles/theme";

export default function EndSessionButton({ style = {}, ...props }) {
  const handleEndSession = () => {
    window.location.assign("/onboarding");
  };

  //OnClick -- Clear local storage, redirect to home page
  return (
    <button
      {...props}
      onClick={handleEndSession}
      style={{
        display: "inline-flex",
        alignItems: "center",
        justifyContent: "center",
        gap: "8px",
        minWidth: "clamp(180px, 16vw, 210px)",
        height: "clamp(56px, 5vw, 66px)",
        padding: "0 clamp(22px, 2vw, 28px)",
        borderRadius: theme.radius.pill,
        border: `2px solid ${"#863C1F"}`,
        background: "#B53A42",
        color: theme.colors.white,
        fontFamily: theme.fonts.sans,
        fontSize: theme.fontSizes.onboardingTagline,
        letterSpacing: "-0.02em",
        cursor: "pointer",
        whiteSpace: "nowrap",
        ...style,
      }}
    >
      End Session
    </button>
  );
}