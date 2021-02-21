3. Remove primary index, add approapriate index


Solution- 
DROP PRIMARY INDEX ON couchbasedemo USING GSI;
SELECT * FROM system:indexes;
