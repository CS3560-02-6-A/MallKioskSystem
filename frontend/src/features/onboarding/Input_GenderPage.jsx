// GENDER INPUT PAGE
import { theme } from "../../styles/theme";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

// COMPONENTS IMPORT
import HeaderBar from "../../components/ui/HeaderBar";
import ProgressBar from "../../components/ui/ProgressBar";
import AppButton from "../../components/ui/AppButton";
import ChoiceCard from "../../components/ui/ChoiceCard";

// FIGMA COMPONENTS IMPORTS
import womanImage from "../../assets/images/woman.png";
import womanImageSelected from "../../assets/images/womanSelected.png";
import neutralImage from "../../assets/images/neutral.png";
import neutralImageSelected from "../../assets/images/neutralSelected.png";
import manImage from "../../assets/images/man.png";
import manImageSelected from "../../assets/images/manSelected.png";

export default function Input_GenderPage() {
    const navigate = useNavigate();
    const [selectedShopper, setSelectedShopper] = useState(null);

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
                <ProgressBar step={1} />
            </HeaderBar>

            <section
                style={{
                width: "100%",
                height: "calc(100vh - 110px)",
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
                justifyContent: "center",
                padding: "0 24px",
                boxSizing: "border-box",
                }}
            >
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

            </section>

            <section
                style={{
                    marginTop: "10px",
                    marginBottom: "10px",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    gap: "50px",
                    flexWrap: "wrap",
                }}
            >
                <ChoiceCard
                    imageSrc={selectedShopper === "man" ? manImageSelected : manImage}
                    alt="man image"
                    selected={selectedShopper === "man"}
                    onClick={() => setSelectedShopper("man")}
                />
                <ChoiceCard
                    imageSrc={selectedShopper === "woman" ? womanImageSelected : womanImage}
                    alt="woman image"
                    selected={selectedShopper === "woman"}
                    onClick={() => setSelectedShopper("woman")}
                />
                <ChoiceCard
                    imageSrc={selectedShopper === "neutral" ? neutralImageSelected : neutralImage}
                    alt="neutral image"
                    selected={selectedShopper === "neutral"}
                    onClick={() => setSelectedShopper("neutral")}
                />
            </section>

            <section
                style={{
                    padding: "5px",
                    justifyContent: "center",
                    display: "flex",
                }}
            >
                <AppButton
                    disabled={!selectedShopper}
                    onClick={() => selectedShopper ? navigate("/occasion") : null}
                >
                    Continue 
                </AppButton>
            </section>

    </main>
    );
}