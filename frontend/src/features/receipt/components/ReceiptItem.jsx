// ReceiptItem.jsx

// Receipt component: The individual item itself layout
// Displays Item image, name, location, price
export default function ReceiptItem({ item }) {
  return (
    <div className="receipt-item">

      {item.imagePath && (
        <img src={item.imagePath} alt={item.name} />
      )}

      <div className="receipt-item-info">
        <h3>{item.name}</h3>
        <div className="receipt-item-pills">
          <span className="receipt-location-pill">
            {item.storeName} - Aisle {item.aisle}
          </span>
          {item.storeHours && (
            <span className="receipt-hours-pill">
              {item.storeHours}
            </span>
          )}
        </div>
      </div>

      <p className="receipt-price">
        ${Number(item.price || 0).toFixed(2)}
      </p>
    </div>
  );
}