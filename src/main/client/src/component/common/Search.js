import React from "react";

const Search = ({ search, setSearch }) => {
  // Correctly prevent form submission default behavior
  const handleSubmit = (e) => {
    e.preventDefault();
  };

  return (
    <div className="col-sm-6 mb-4">
      <form onSubmit={handleSubmit}>
        <input
          className="form-control"
          type="search"
          role="searchbox"
          placeholder="Search Student..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
      </form>
    </div>
  );
};

export default Search;
