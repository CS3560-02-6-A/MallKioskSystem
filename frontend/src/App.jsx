import ReceiptPage from "./features/outfit-curator/pages/ReceiptPage";
import OnboardingPage from "./features/onboarding/pages/OnboardingPage";
import InputPage from "./features/onboarding/pages/InputPage";
import OccasionPage from "./features/outfit-curator/pages/OccasionPage";
import OutfitBuilderPage from "./features/outfit-curator/pages/OutfitBuilderPage";
import { Navigate, Route, Routes } from "react-router-dom";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<OnboardingPage />} /> {/* Default route */}
      <Route path="*" element={<Navigate to="/onboarding" replace />} />
      <Route path="/onboarding" element={<OnboardingPage />} />
      <Route path="/input" element={<InputPage />} />
      <Route path="/occasion" element={<OccasionPage />} />
      <Route path="/outfit" element={<OutfitBuilderPage />} />
      <Route path="/receipt" element={<ReceiptPage />} />
    </Routes>
  );
}
