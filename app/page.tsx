async function getData() {
  const res = await fetch('https://api.adball.tech/...');
  // The return value is *not* serialized
  // You can return Date, Map, Set, etc.
  return res.json();
}

export default async function Page() {
  const name = await getData();

  return '...';
}
