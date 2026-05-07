import { useState, useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { theme } from "../../styles/theme";
import HeaderBar from "../../components/ui/HeaderBar";
import AppButton from "../../components/ui/AppButton";
import OutfitCategoryCard from "./components/OutfitCategoryCard";

const CATEGORIES = [
  { label: "Accessories", flexGrow: 1, types: ["accessory", "jacket", "sweater", "robe"] },
  { label: "Top",         flexGrow: 1, types: ["shirt"] },
  { label: "Bottom",      flexGrow: 1.6, types: ["pants", "skirt", "shorts"] },
  { label: "Shoes",       flexGrow: 0.5, types: ["heels", "sandals", "sneakers", "dressshoe", "shoes"] },
];

function getCategoryForType(type) {
  const t = String(type || "").trim().toLowerCase();
  const cat = CATEGORIES.find((c) => c.types.includes(t));
  return cat ? cat.label : null;
}

// Convert a list of items into an object like { Top: item, Shoes: item }.
function buildSelectedItemsByCategory(items) {
  return items.reduce((selectedByCategory, item) => {
    const category = getCategoryForType(item.type);

    if (!category) {
      return selectedByCategory;
    }

    selectedByCategory[category] = item;
    return selectedByCategory;
  }, {});
}

export default function OutfitBuilderPage() {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();

  const occasion = searchParams.get("occasion");
  const gender = searchParams.get("gender");

  const [selectedCategory, setSelectedCategory] = useState(null);
  const [allItems, setAllItems] = useState([]);

  // Stores the user's current pick for each category button.
  const [selectedItems, setSelectedItems] = useState({});

  // items matching the currently selected category button
  const visibleItems = selectedCategory
    ? allItems.filter((item) => getCategoryForType(item.type) === selectedCategory)
    : [];

  const filledCount = Object.keys(selectedItems).length;

  // handle item selection - store item by category
  function onSelectItem(category, item) {
    setSelectedItems((prev) => ({
      ...prev,
      [category]: item,
    }));
  }

  // fetch the full filtered catalog once on load
  async function fetchAllItems() {
    try {
      const params = new URLSearchParams();
      if (occasion) params.append("occasion", occasion);
      if (gender)   params.append("gender",   gender);

      const res  = await fetch(`http://localhost:8080/api/items?${params.toString()}`);
      const data = await res.json();
      setAllItems(data);
    } catch (error) {
      console.error("Failed to fetch items:", error);
    }
  }

  // random outfit via /api/outfit
  async function fetchOutfit() {
    try {
      const params = new URLSearchParams();
      if (occasion) params.append("occasion", occasion);
      if (gender)   params.append("gender",   gender);

      const res  = await fetch(`http://localhost:8080/api/outfit?${params.toString()}`);
      const data = await res.json();
      setSelectedItems(buildSelectedItemsByCategory(data));
      setSelectedCategory(null);
    } catch (error) {
      console.error("Failed to fetch outfit:", error);
    }
  }

  useEffect(() => {
    fetchAllItems();
  }, [occasion, gender]);

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
              gap: "12px",
              flex: 1,
              minHeight: 0,
            }}
          >
            {CATEGORIES.map((cat) => {
              const isSelected = selectedCategory === cat.label;

              return (
                <button
                  key={cat.label}
                  type="button"
                  aria-pressed={isSelected}
                  onClick={() => setSelectedCategory(cat.label === selectedCategory ? null : cat.label)}
                  style={{
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    width: "50%",
                    flex: cat.flexGrow,
                    minHeight: 0,
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
                  }}
                >
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "column",
                      alignItems: "center",
                      gap: "4px",
                      textAlign: "center",
                    }}
                  >
                    <span>{cat.label}</span>
                    {selectedItems[cat.label] && (
                      <span
                        style={{
                          fontSize: "0.75em",
                          fontWeight: theme.fontWeights.light,
                          color: theme.colors.mutedText,
                        }}
                      >
                        {selectedItems[cat.label].name}
                      </span>
                    )}
                  </div>
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
              flexDirection: "row",
              flexWrap: "wrap",
              alignItems: "flex-start",
              justifyContent: "flex-start",
              gap: "20px",
              flex: 1,
              overflow: "auto",
              padding: "16px",
            }}
          >
            {/* No category selected → show Generate button */}
            {!selectedCategory && (
              <>
                <p
                  style={{
                    fontFamily: theme.fonts.sans,
                    fontSize: theme.fontSizes.onboardingTagline,
                    color: theme.colors.mutedText,
                    margin: 0,
                  }}
                >
                  Choose a category on the left, or generate an outfit.
                </p>
                <AppButton onClick={fetchOutfit}>Generate Random Outfit</AppButton>
              </>
            )}

            {/* Category selected but no matches */}
            {selectedCategory && visibleItems.length === 0 && (
              <p
                style={{
                  fontFamily: theme.fonts.sans,
                  fontSize: theme.fontSizes.onboardingTagline,
                  color: theme.colors.mutedText,
                  margin: 0,
                }}
              >
                No items found for this category.
              </p>
            )}

            {/* Category item cards */}
            {selectedCategory && visibleItems.map((item) => (
              <OutfitCategoryCard
                key={`${item.itemId}-${item.storeId}`}
                item={{
                  itemId: item.itemId,
                  imageSrc: item.imagePath || "",
                  name: item.name,
                  type: item.type,
                  color: item.color,
                  gender: item.gender,
                  price: item.price,
                  storeId: item.storeId,
                  aisle: item.aisle,
                }}
                category={selectedCategory}
                onSelectItem={onSelectItem}
                isSelected={
                  selectedItems[selectedCategory]?.itemId === item.itemId
                  && selectedItems[selectedCategory]?.storeId === item.storeId
                }
              />
            ))}

            {filledCount === CATEGORIES.length && (
  <AppButton
    onClick={() => {
      console.log("sending outfit:", selectedItems);
      navigate("/receipt", {
        state: { outfit: selectedItems },
      });
    }}
  >
    Finish Outfit
  </AppButton>
)}
          </div>
        </div>
      </div>
    </main>
  );
}