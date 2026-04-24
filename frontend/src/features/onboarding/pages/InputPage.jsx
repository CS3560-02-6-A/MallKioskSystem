import { theme } from "../../../styles/theme";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import HeaderBar from "../../../components/ui/HeaderBar";
import ProgressBar from "../../../components/ui/ProgressBar";
import AppButton from "../../../components/ui/AppButton";
import GoBackButton from "../../../components/ui/GoBackButton";
import womanImage from "../../../assets/images/woman.png";
import womanImageSelected from "../../../assets/images/womanSelected.png";
import neutralImage from "../../../assets/images/neutral.png";
import neutralImageSelected from "../../../assets/images/neutralSelected.png";
import manImage from "../../../assets/images/man.png";
import manImageSelected from "../../../assets/images/manSelected.png";

export default function InputPage({ setShowInputPage }) {
    const navigate = useNavigate();

  return (
    <main
    style={{
        height: "100vh",
        width: "100%",
        overflow: "scroll",
        background: theme.colors.page,
        color: theme.colors.text,
        fontFamily: theme.fonts.sans,
    }}
>
        <HeaderBar> 
            <ProgressBar/>
        </HeaderBar>
            <h1
                style={{
                    justifyContent: "center",
                    display: "flex",
                    fontFamily: theme.fonts.display,
                    fontSize: theme.fontSizes.onboardingTitle,
                    fontWeight: theme.fontWeights.regular,
                    lineHeight: theme.lineHeights.tight,
                    color: theme.colors.text,
                }}
            >
                How would you like to shop?
            </h1>
            <p
            style={{
              justifyContent: "center",
              display: "flex",
              fontFamily: theme.fonts.sans,
              fontSize: theme.fontSizes.onboardingTagline,
              fontWeight: theme.fontWeights.light,
              lineHeight: theme.lineHeights.normal,
              color: theme.colors.mutedText,
            }}
          >
            This filters the catalog.
          </p>
            <section
                style={{
                    marginTop: "10px",
                    marginBottom: "10px",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    gap: "50px",
                }}
                >
                <button>
                    <img
                        src={manImage}
                        alt="man image"
                        style={{
                            width: "318px",
                            maxWidth: "424px",
                            maxHeight: "544px",
                            height: "408px",
                            objectFit: "contain",
                            display: "block",
                        }}
                    />
                </button>
                <button>
                    <img
                        src={womanImage}
                        alt="woman image"
                        style={{
                            width: "318px",
                            maxWidth: "424px",
                            maxHeight: "544px",
                            height: "408px",
                            objectFit: "contain",
                            display: "block",
                        }}
                    />
                </button>
                <button>
                    <img
                        src={neutralImage}
                        alt="neutral image"
                        style={{
                            width: "318px",
                            maxWidth: "424px",
                            maxHeight: "544px",
                            height: "408px",
                            objectFit: "contain",
                            display: "block",
                        }}
                    />
                </button>
            </section>
            <section
                style={{
                    padding: "5px",
                    justifyContent: "center",
                    display: "flex",
                }}
            >
            <AppButton Onclick={() => navigate("/occasion")}>
                Continue
            </AppButton>
            </section>
    </main>
    );
}