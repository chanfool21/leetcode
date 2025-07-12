import React, { useState } from "react";

const API = "http://localhost:8080/api/game";

function App() {
  const [size, setSize] = useState(6);
  const [ship, setShip] = useState({ id: "", size: 2, xA: 0, yA: 0, xB: 0, yB: 0 });
  const [log, setLog] = useState("");
  const [battlefield, setBattlefield] = useState([]);

  // Initialize game
  const initGame = async () => {
    await fetch(`${API}/init`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ size }),
    });
    setLog("Game initialized.");
    setBattlefield([]);
  };

  // Add ship
  const addShip = async () => {
    await fetch(`${API}/ship`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(ship),
    });
    setLog(`Ship ${ship.id} added.`);
  };

  // Start game
  const startGame = async () => {
    const res = await fetch(`${API}/start`, { method: "POST" });
    const text = await res.text();
    setLog(text);
    fetchBattlefield();
  };

  // View battlefield
  const fetchBattlefield = async () => {
    const res = await fetch(`${API}/state`);
    const data = await res.json();
    setBattlefield(data);
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>Battleship Game</h1>
      <div>
        <label>Board Size: </label>
        <input type="number" value={size} onChange={e => setSize(Number(e.target.value))} min={4} max={20} />
        <button onClick={initGame}>Initialize Game</button>
      </div>
      <hr />
      <div>
        <h2>Add Ship</h2>
        <input placeholder="ID" value={ship.id} onChange={e => setShip({ ...ship, id: e.target.value })} />
        <input type="number" placeholder="Size" value={ship.size} onChange={e => setShip({ ...ship, size: Number(e.target.value) })} />
        <input type="number" placeholder="A x" value={ship.xA} onChange={e => setShip({ ...ship, xA: Number(e.target.value) })} />
        <input type="number" placeholder="A y" value={ship.yA} onChange={e => setShip({ ...ship, yA: Number(e.target.value) })} />
        <input type="number" placeholder="B x" value={ship.xB} onChange={e => setShip({ ...ship, xB: Number(e.target.value) })} />
        <input type="number" placeholder="B y" value={ship.yB} onChange={e => setShip({ ...ship, yB: Number(e.target.value) })} />
        <button onClick={addShip}>Add Ship</button>
      </div>
      <hr />
      <button onClick={startGame}>Start Game (Auto-play)</button>
      <button onClick={fetchBattlefield}>View Battlefield</button>
      <pre style={{ background: "#eee", padding: 10 }}>{log}</pre>
      <BattlefieldGrid grid={battlefield} />
    </div>
  );
}

function BattlefieldGrid({ grid }) {
  if (!grid || grid.length === 0) return null;
  return (
    <table border="1" style={{ marginTop: 20 }}>
      <tbody>
        {grid.map((row, i) => (
          <tr key={i}>
            {row.map((cell, j) => (
              <td key={j} style={{ width: 30, height: 30, textAlign: "center" }}>
                {cell || "."}
              </td>
            ))}
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default App; 