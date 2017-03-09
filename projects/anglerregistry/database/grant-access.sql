GRANT SELECT, INSERT, UPDATE, DELETE ON 
	anglerregistry.fish,
	anglerregistry.horgasz, 
	anglerregistry.lake, 
	anglerregistry.telepites, 
	anglerregistry.engedely,
	anglerregistry.fogasinaplo
TO anglerregistry_role;
    
GRANT USAGE, SELECT, UPDATE ON anglerregistry.fish_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.horgasz_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.lake_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.telepites_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.engedely_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.fogasinaplo_id_seq TO anglerregistry_role;