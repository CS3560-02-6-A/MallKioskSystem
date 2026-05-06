import { useState, useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { theme } from "../../styles/theme";
import HeaderBar from "../../components/ui/HeaderBar";
import AppButton from "../../components/ui/AppButton";
import OutfitCategoryCard from "./components/OutfitCategoryCard";

const CATEGORIES = [
  { label: "Accessories", height: "120px" },
  { label: "Top", height: "200px" },
  { label: "Bottom", height: "340px" },
  { label: "Shoes", height: "150px" },
];

export default function OutfitBuilderPage() {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();

  const occasion = searchParams.get("occasion");
  const gender = searchParams.get("gender");

  const [selectedCategory, setSelectedCategory] = useState(null);
  const [outfit, setOutfit] = useState([]);

  const filledCount = outfit.length;

  async function fetchOutfit() {
    try {
      const params = new URLSearchParams();

      if (occasion) {
        params.append("occasion", occasion);
      }
      if (gender) {
        params.append("gender", gender);
      }

      const url = `http://localhost:8080/api/outfit?${params.toString()}`;

      console.log("Fetching outfit from:", url);

      const res = await fetch(url);
      const data = await res.json();

      console.log("Received outfit:", data);

      setOutfit(data);
    } catch (error) {
      console.error("Failed to fetch outfit:", error);
    }
  }

  useEffect(() => {
    fetchOutfit();
  }, [occasion]);

  return (
    <main
      style={{
        height: "100vh",
        width: "100%",
        display: "flex",
        flexDirection: "column",
        overflow: "scroll",
        background: theme.colors.page,
        color: theme.colors.text,
        fontFamily: theme.fonts.sans,
      }}
    >
      <HeaderBar leftButton="← Change Filters">
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
          Outfit Curator
        </h1>
      </HeaderBar>

      <div
        style={{
          display: "flex",
          flexDirection: "row",
          width: "100%",
          flex: 1,
          minHeight: 0,
        }}
      >
        {/* Left side category buttons */}
        <div
          style={{
            display: "flex",
            flexDirection: "column",
            width: "35%",
            minWidth: "280px",
            gap: "12px",
            overflowY: "auto",
            padding: "8px 10px 16px 10px",
          }}
        >
          <p
            style={{
              textAlign: "right",
              margin: 0,
              fontFamily: theme.fonts.sans,
              fontSize: theme.fontSizes.onboardingTagline,
              fontWeight: theme.fontWeights.bold,
              color: "#B53A42",
            }}
          >
            {filledCount}/{CATEGORIES.length} items
          </p>

          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              gap: "22px",
            }}
          >
            {CATEGORIES.map((cat) => {
              const isSelected = selectedCategory === cat.label;

              return (
                <button
                  key={cat.label}
                  type="button"
                  aria-pressed={isSelected}
                  onClick={() => setSelectedCategory(cat.label)}
                  style={{
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    width: "50%",
                    height: cat.height,
                    borderRadius: "12px",
                    border: `2px solid ${theme.colors.lightBrown}`,
                    background: isSelected
                      ? theme.colors.tan
                      : theme.colors.palePink,
                    cursor: "pointer",
                    fontFamily: theme.fonts.sans,
                    fontSize: theme.fontSizes.onboardingTagline,
                    fontWeight: theme.fontWeights.regular,
                    color: theme.colors.text,
                    flexShrink: 0,
                  }}
                >
                  {cat.label}
                </button>
              );
            })}
          </div>
        </div>

        {/* Right side outfit area */}
        <div
          style={{
            display: "flex",
            flexDirection: "column",
            flex: 1,
            background: theme.colors.palePink,
            overflow: "hidden",
            boxShadow: theme.shadows.dropShadow,
          }}
        >
          <div
            style={{
              width: "100%",
              background: theme.colors.offWhite,
              flexShrink: 0,
            }}
          >
            <h2
              style={{
                fontFamily: theme.fonts.display,
                fontWeight: theme.fontWeights.regular,
                fontSize: "clamp(22px, 2.4vw, 36px)",
                color: theme.colors.text,
                margin: "14px 0",
                textAlign: "center",
              }}
            >
              Create your outfit!
            </h2>
          </div>

          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              justifyContent: outfit.length > 0 ? "flex-start" : "center",
              gap: "30px",
              flex: 1,
              overflow: "auto",
              padding: "16px",
            }}
          >
            {outfit.length === 0 && (
              <>
                <p
                  style={{
                    fontFamily: theme.fonts.sans,
                    fontSize: theme.fontSizes.onboardingTagline,
                    color: theme.colors.mutedText,
                    margin: 0,
                  }}
                >
                  No outfit generated yet.
                </p>

                <AppButton onClick={fetchOutfit}>
                  Generate Random Outfit
                </AppButton>
              </>
            )}

            {outfit.map((item) => (
              <OutfitCategoryCard
                key={`${item.itemId}-${item.storeId}`}
                item={{
                  imageSrc: item.imagePath || "",
                  name: item.name,
                  type: item.type,
                  color: item.color,
                  gender: item.gender,
                  price: item.price,
                  storeId: item.storeId,
                  aisle: item.aisle,
                }}
              />
            ))}

            {outfit.length > 0 && (
              <AppButton onClick={fetchOutfit}>
                Generate New Outfit
              </AppButton>
            )}

            {outfit.length > 0 && (
              <AppButton onClick={() => navigate("/receipt")}>
                Finish Outfit
              </AppButton>
            )}
          </div>
        </div>
      </div>
    </main>
  );
}