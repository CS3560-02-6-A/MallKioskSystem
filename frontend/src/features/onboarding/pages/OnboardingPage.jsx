import { ArrowRight } from "lucide-react";
import { useNavigate } from "react-router-dom";
import AppButton from "../../../components/ui/AppButton";
import { theme } from "../../../styles/theme";
import sketchImage from "../../../assets/images/img_sketch.png";

export default function OnboardingPage() {
  const navigate = useNavigate();

  return (
    <main
      style={{
        height: "100vh",
        width: "100%",
        overflow: "hidden",
        background: theme.colors.page,
        color: theme.colors.text,
        fontFamily: theme.fonts.sans,
      }}
    >
      <section
        style={{
          width: "100%",
          height: "100%",
          display: "grid",
          gridTemplateColumns: "minmax(0, 1fr) minmax(0, 1fr)",
          alignItems: "center",
          gap: "clamp(24px, 4vw, 64px)",
          padding: "clamp(20px, 3vw, 36px)",
          boxSizing: "border-box",
          overflow: "hidden",
        }}
      >
        <div
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            minWidth: 0,
            minHeight: 0,
          }}
        >
          <img
            src={sketchImage}
            alt="Fashion sketch"
            style={{
              width: "100%",
              maxWidth: "min(42vw, 520px)",
              maxHeight: "78vh",
              height: "auto",
              objectFit: "contain",
              display: "block",
            }}
          />
        </div>

        <div
          style={{
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "flex-start",
            minWidth: 0,
            minHeight: 0,
            width: "100%",
          }}
        >
          <p
            style={{
              margin: 0,
              fontFamily: theme.fonts.display,
              fontSize: theme.fontSizes.onboardingWelcome,
              fontWeight: theme.fontWeights.regular,
              lineHeight: theme.lineHeights.normal,
              color: theme.colors.text,
            }}
          >
            Welcome to...
          </p>

          <h1
            style={{
              margin: "clamp(8px, 1vw, 12px) 0 0 0",
              fontFamily: theme.fonts.display,
              fontSize: theme.fontSizes.onboardingTitle,
              fontWeight: theme.fontWeights.regular,
              lineHeight: theme.lineHeights.tight,
              color: theme.colors.text,
            }}
          >
            Outfit Curator
          </h1>

          <p
            style={{
              margin: "clamp(14px, 1.5vw, 18px) 0 0 0",
              fontFamily: theme.fonts.sans,
              fontSize: theme.fontSizes.onboardingTagline,
              fontWeight: theme.fontWeights.light,
              fontStyle: "italic",
              lineHeight: theme.lineHeights.normal,
              color: theme.colors.mutedText,
            }}
          >
            Build your look.
          </p>

          <div
            style={{
              marginTop: "clamp(34px, 5vh, 54px)",
              width: "100%",
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <AppButton
              onClick={() => navigate("/input")}
              rightIcon={<ArrowRight size={22} strokeWidth={2.8} />}
            >
              Get started
            </AppButton>

            <button
              style={{
                marginTop: "clamp(14px, 2vh, 18px)",
                padding: 0,
                border: "none",
                background: "transparent",
                fontFamily: theme.fonts.sans,
                fontSize: theme.fontSizes.onboardingLink,
                fontWeight: theme.fontWeights.light,
                color: theme.colors.link,
                textDecoration: "underline",
                textUnderlineOffset: "5px",
                cursor: "pointer",
              }}
            >
              Learn more
            </button>
          </div>
        </div>
      </section>
    </main>
  );
}